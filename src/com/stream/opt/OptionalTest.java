package com.stream.opt;

import org.junit.Test;

import java.util.Optional;

/**
 * @Author zwb
 * @DATE 2020/9/4 09:55
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<Object> optional1 = Optional.empty();
        Optional<User> optional2 = Optional.of(new User());
        Optional<Object> optional3 = Optional.ofNullable(null);


        User user = new User();
        Address address = new Address();
        address.setDetails("北京市xxx街道");
        user.setName("张三");
        user.setAddress(address);

        System.out.println(getUserAddr(user));
        System.out.println(getUserAddr(Optional.ofNullable(null)));


    }

    private static String getUserAddr(User user){
        if(user != null){
            Address address = user.getAddress();
            if(address != null){
                return address.getDetails();
            }else {
                return "地址信息未填写";
            }
        }else {
            return "地址信息未填写";
        }
    }

    //注意此时user类型为Optional<User>
    private static String getUserAddr(Optional<User> user){
        //如果user存在，则取address对象
        if(user.isPresent()){
            Address address = user.get().getAddress();
            //把address包装成Optional对象
            Optional<Address> addressOptional = Optional.ofNullable(address);
            //如果address存在，则取details地址信息
            if(addressOptional.isPresent()){
                return addressOptional.get().getDetails();
            }else {
                return "地址信息未填写";
            }
        }else{
            return "地址信息未填写";
        }
    }

    private static String getUserAddr1(Optional<User> user){
        return user.map((u)->u.getAddress())
                .map(e -> e.getDetails())
                .orElse("地址信息未填写");
    }

    @Test
    public void test(){
        User user = new User();
        String name = Optional.of(user).map(User::getName)
                .orElse("佚名");
        System.out.println(name);


    }

    @Test
    public void test1(){
        User user = null;
        System.out.println("orElse调用");
        User user1 = Optional.ofNullable(user).orElse(createUser());
        System.out.println("orElseGet调用");
        User user2 = Optional.ofNullable(user).orElseGet(() -> createUser());
    }

    private User createUser() {
        //此处打印，是为了查看orElse和orElseGet的区别
        System.out.println("createUser...");
        return new User();
    }

    @Test
    public void test2(){
        User user = new User();
        System.out.println("orElse调用");
        User user1 = Optional.ofNullable(user).orElse(createUser());
        System.out.println("orElseGet调用");
        User user2 = Optional.ofNullable(user).orElseGet(() -> createUser());
    }

    @Test
    public void test3(){
        User user = new User();

    }

    private Optional<String> getUserName(User user){
        return Optional.ofNullable(user.getName());
    }
}
