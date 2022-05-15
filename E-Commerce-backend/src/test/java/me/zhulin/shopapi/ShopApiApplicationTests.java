package me.zhulin.shopapi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.insa.issam.ecommerce.service.impl.*;
import me.zhulin.shopapi.service.impl.CartServiceImplTest;
import me.zhulin.shopapi.service.impl.CategoryServiceImplTest;
import me.zhulin.shopapi.service.impl.OrderServiceImplTest;
import me.zhulin.shopapi.service.impl.ProductInOrderServiceImplTest;
import me.zhulin.shopapi.service.impl.ProductServiceImplTest;
import me.zhulin.shopapi.service.impl.UserServiceImplTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CartServiceImplTest.class,
        CategoryServiceImplTest.class,
        OrderServiceImplTest.class,
        ProductInOrderServiceImplTest.class,
        ProductServiceImplTest.class,
        UserServiceImplTest.class
})
public class ShopApiApplicationTests {

}

