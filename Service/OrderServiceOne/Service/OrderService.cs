using Microsoft.Extensions.Logging;
using Newtonsoft.Json;
using OrderServiceOne.Models;
using Pivotal.Discovery.Client;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace OrderServiceOne.Service
{
    public class OrderService : IOrderService
    {
        DiscoveryHttpClientHandler _handler;
        ILogger<OrderService> _logger;
        /// <summary>
        /// 内部调用
        /// http://localhost:8080/product-service-netcore/api/product
        /// </summary>
        private const string product_service_url = "http://product-service-netcore/api/product";

        public OrderService(IDiscoveryClient client, ILoggerFactory logFactory)
        {
            _handler = new DiscoveryHttpClientHandler(client, logFactory.CreateLogger<DiscoveryHttpClientHandler>());
            // Remove comment to use SSL communications with Self-Signed Certs
            // _handler.ServerCertificateCustomValidationCallback = (a,b,c,d) => {return true;};
            this._logger = logFactory.CreateLogger<OrderService>();
        }
        private HttpClient GetClient()
        {
            var client = new HttpClient(_handler, false);
            return client;
        }

        private async Task<string> GetProduct()
        {
            var client = GetClient();
            var result = await client.GetStringAsync(product_service_url);
            _logger.LogInformation("GetProduct: {0}", result);
            return result;
        }
        private string GetOrderInfo()
        {
            var product = GetProduct();
            return product.Result;
            var order = new OrderDto { Code = 200, OrderNo = "111" };
            return JsonConvert.SerializeObject(order);
        }

        public async Task<string> GetOrderInfoAsync()
        {
            return await Task.Run<string>(() =>
            {
                return GetOrderInfo();
            }
            );
        }
    }
}
