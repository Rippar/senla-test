package by.murzo.inetshop.projection;

public interface OrderView {

    Long getId();
    Long getUserId();
    String getStatus();
    String getCreatedAt();
    String getProductsId();
}
