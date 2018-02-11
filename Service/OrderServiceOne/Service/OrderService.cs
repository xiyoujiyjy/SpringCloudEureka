using Newtonsoft.Json;
using OrderServiceOne.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderServiceOne.Service
{
    public class OrderService : IOrderService
    {
        private string GetOrderInfo()
        {
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
