using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrderServiceOne.Service
{
    public interface IOrderService
    {
        Task<string> GetOrderInfoAsync();

    }
}
