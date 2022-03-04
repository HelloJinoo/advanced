package hello.advanced.v0;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderContorllerV0 {

    private final OrderServiceV0 orderService;


    @GetMapping("/v0/request")
    public String request(String itemid){
        orderService.orderItem(itemid);
        return "ok";
    }
}
