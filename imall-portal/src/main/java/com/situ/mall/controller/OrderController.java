package com.situ.mall.controller;

import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.pojo.User;
import com.situ.mall.pojo.VO.CartVO;
import com.situ.mall.service.ICartService;
import com.situ.mall.service.IOrderService;
import com.situ.mall.service.IShippingService;
import com.situ.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IShippingService shippingService;
    @Autowired
    private ICartService cartService;

    @RequestMapping("/getConfirmOrderPage")
    public String getConfirmOrderPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Shipping> shippingList = shippingService.selectByUserId(user.getId());
        model.addAttribute("shippingList",shippingList);

        List<CartVO> cartVOList = cartService.selectByUserIdAndChecked(user.getId());
        model.addAttribute("cartVOList", cartVOList);
        return "confirm_order";
    }

    @ResponseBody
    @RequestMapping("/add")
    public JSONResult add(Order order, HttpSession session) {
        User user = (User) session.getAttribute("user");
        order.setUserId(user.getId());
        orderService.add(order);
        return JSONResult.ok("生成订单成功");
    }

    @RequestMapping("/getOrderListPage")
    public String getOrderListPage() {
        return "order_list";
    }
}
