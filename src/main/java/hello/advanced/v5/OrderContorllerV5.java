package hello.advanced.v5;


import hello.advanced.trace.callback.TraceCallBack;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderContorllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderContorllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemid) {
        return template.execute("OrderController.request()", new TraceCallBack<>() {
            @Override
            public String call() {
                orderService.orderItem(itemid);
                return "ok";
            }
        });
    }
}
