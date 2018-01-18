package com.mg.mf;

import com.cmgame.bridge.EncryptionUtil;

public class TestBridge {
    
    public static void main(String[] args) {
        String PRIVATEKEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIgy4YqWn/c8OYHSyEz5Pl6hCcm6le4qlvRfJbtcSCEeHDVq5zDoWmJF2CO5nT2Ym1xM46S/Fx3G8xEWOfuoCQYyQRNWYJPp0N2XaniC1qYdZnpWf+ozothSxi7Gk39HJDKEH5cpFw0/UymInfJB1YJlnZEpimUQTu0faQF83RZDAgMBAAECgYBbhY1nupXd5lticMjmaKpPnnlcVISBmZ78sZ9CSt2xW3FrN94JUGnEFdkLEKSoCo+Ds6tZPouDF/ioJ75o7F67DfqqJXAzcT6U6ZI+xlpET+Z2SL60wOxIIw8vBwSX/Lr1/S6cyuo+8TjEgYvpnHYBKShSX3n5cwa0/hkgRvk5wQJBAM57g4nGCJDE4ATEmTiGwRuThAAHgS+60kztkcY7LjSkApCIXyUO03rDG3gLo+UGlvQNskBjaQpr4AKbHZQgZiECQQCo3HhazMx0/WwSY2po+EJgAhHp4JCvfsFJn8vV8+h/8uFIcKNMRrdv3loqxjK2rhEQiK7JLbjh67lh/YCrI6fjAkEAoRkE261CaZDxJ0csNEoOyDEjv9IbHN4pzhNctMjfl/qOda2wbf1PSmyHNfX+/WVSyT8WX94vyg24TNAxF6zfgQJAHB5CSFRsA1sjwNgfIwWb/+K4WuqTDTYdN4ZNaf4ojA3Ep8xh1NS9vPoYp6DDVxobK1anTEa5z5zyDLgq0dSpIwJBAKa6SSONRBPaVqZwVvcJV68Aj7meDnyS7kQEcI6rVV/zDzW+9oNb2OvSP/Lb+1FaAigKJvMhEUnZLC7wBmAkr/Q=";
        
        String entryStr = "BL9XasojrFkDTrga7E2brAgE5dS7FdI1KkgYvacvz34juYdWG2dOoio4g6KmyirtIMNvaKsETbGNzoiK3y6HbHT0WJYy2B6PzQRqbe8L5wlQYy4NZrKhxlh8b46Te53gn/s/q8+/tjPSM7QLWI5901mnMaox/g7HoBVuW0ZM7eh4AqZ/Em/Z2BjCl5pvMtfXw4J58mAgG3W3B/ZBnmhGi8lQzIjvY5PNAnOZbjotn7Ua+gSjvr3P/sKNuGhMHu2YIQuCiSrg7uftrfBk9Rb9VimZ0d9gaOvY7ckdMahDiSQVvJWdYPVYcBzwmLBBF/4tLkW0x62xvKbtAR90V5bMCgMFHpHLXWo5Q44I7RwPCLA1cvx7UltMgqeaHZ7CAJ9MqkseN4lu2yDcXeIHlV2SnT33qmOfjYLJykwotUvndXl3gAkfOTcGcd09pepeU6UeVZw/MttYadQ6VzFm1WI6eaY0gzL0U/0T72RMLWtUJRRT95hrLNQwVaFBYQmQUqcT";
        
        String dataEncrypt = EncryptionUtil.getPrivateKeyAndDecrypt(PRIVATEKEY, entryStr);
        System.out.println(dataEncrypt);
    }


}
