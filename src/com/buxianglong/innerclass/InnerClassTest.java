package com.buxianglong.innerclass;

public class InnerClassTest {
    
    
    class User{
        public String name;
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "name is:"+this.name;
        }
    }
    
    
    public void test()
    {
        User u = new User();
        u.name = "zzz";
        System.out.println(u.toString());
    }
    
    public static void main(String[] args) throws Exception{
        InnerClassTest t = new InnerClassTest();
        t.test();
    }

}
