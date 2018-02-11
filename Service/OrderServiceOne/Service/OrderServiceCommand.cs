using Steeltoe.CircuitBreaker.Hystrix;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.Extensions.Logging;

namespace OrderServiceOne.Service
{
    public class OrderServiceCommand : HystrixCommand<string>
    {
        IOrderService _orderService;
        ILogger<OrderServiceCommand> _logger;

        public OrderServiceCommand(IHystrixCommandOptions options, IOrderService fortuneService, ILogger<OrderServiceCommand> logger) : base(options)
        {
            _orderService = fortuneService;
            _logger = logger;
            IsFallbackUserDefined = true;
        }
        public async Task<string> OrderInfo()
        {
            return await ExecuteAsync();
        }
        protected override async Task<string> RunAsync()
        {
            var result = await _orderService.GetOrderInfoAsync();
            _logger.LogInformation("Run: {0}", result);
            return result;
        }

        protected override async Task<string> RunFallbackAsync()
        {
            _logger.LogInformation("RunFallback");
            return await Task.FromResult<string>("断路器 fallback");
        }
    }
}
