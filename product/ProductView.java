package product;

import common.UtilService;
import common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductView {

    private static List<Product> products;

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();
        for(int i = 0; i < 5; i++)
            products.add(Product.builder()
                    .i(util.createRandomInt(0, 10))
                    .name(util.createRandomName())
                    .company(util.createRandomCompany())
                    .price(util.createRandomInt(1000, 9000)).build());

        products.forEach(i -> System.out.println(i.toString()));
    }
}
