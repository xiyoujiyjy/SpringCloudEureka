using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using OrderServiceOne.Service;

namespace OrderServiceOne.Controllers
{
    [Produces("application/json")]
    [Route("api/Order")]
    public class OrderController : Controller
    {
        private OrderServiceCommand _orderService;
        public OrderController(OrderServiceCommand orderServiceCommand)
        {
            _orderService = orderServiceCommand;
        }
        [Route("GetOrderInfo")]
        [HttpGet]
        public string GetOrderInfo()
        {
            return _orderService.Execute();

        }
        public async Task<string> GetOrderInfoAsync()
        {
            return await _orderService.ExecuteAsync();
            // return await _orderService.OrderInfo();
        }
        // GET: api/Order
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "8101", "8101" };
        }

        // GET: api/Order/5
        [HttpGet("{id}", Name = "Get")]
        public string Get(int id)
        {
            return "8101";
        }

        // POST: api/Order
        [HttpPost]
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Order/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
