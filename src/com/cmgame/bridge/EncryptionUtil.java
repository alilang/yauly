package com.cmgame.bridge;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;

import javax.crypto.Cipher;

/**
* @author JavaDigest
*
 */
public class EncryptionUtil {
  /**
   * String to hold name of the encryption algorithm.
   */
  public static final String ALGORITHM = "RSA";


  public static String[] splitString(String text, int size)
  {
      if(null == text || size <=0)
      {
          return null;
      }

      String[] ret = null;
      int testLen = text.length();
      int mod = testLen%size;
      int retlen = mod == 0 ? (testLen/size) : (testLen/size) + 1;
      ret = new String[retlen];

      int beginIndex = 0;
      int endIndex = 0;

      if(0 == mod)
      {
          for(int i= 0; i < retlen; i++)
          {
              beginIndex = endIndex;
              endIndex += size;
              ret[i] = text.substring(beginIndex, endIndex);
          }
      }
      else
      {
          for(int i= 0; i < retlen; i++)
          {
              beginIndex = endIndex;
              if(i < retlen - 1)
              {
                  endIndex += size;
              }
              else
              {
                  endIndex += mod;
              }
              ret[i] = text.substring(beginIndex, endIndex);
          }
      }
      return ret;
  }

  public static byte[] listToArray(ArrayList<Byte> src)
  {
      byte[] ret = null;
      int len = src.size();
      if(null == src || len <= 0)
      {
          return ret;
      }
      ret = new byte[len];
      for(int i = 0; i < len; i++)
      {
          ret[i] = src.get(i);
      }
      return ret;
  }

  /**
   * Encrypt the plain text using public key.
   *
   * @param text
   *          : original plain text
   * @param publicKey
   *          :The public key
   * @return Encrypted text
   * @throws java.lang.Exception
   */
  public static String RSAencrypt(String text, Key publicKey) {

    byte[] cipherText = null;
    try {
      ArrayList<Byte> temp = new ArrayList<Byte>();
      // get an RSA cipher object and print the provider
      final Cipher cipher = Cipher.getInstance(ALGORITHM);
      // encrypt the plain text using the public key
      cipher.init(Cipher.ENCRYPT_MODE, publicKey);

      String[] textArray = splitString(text, 117);
      for(int i = 0; i < textArray.length; i++){
          byte[] buf = cipher.doFinal(textArray[i].getBytes());
          for(int j = 0; j < buf.length; j++)
          {
              temp.add(buf[j]);
          }
      }
      cipherText = listToArray(temp);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return Base64.encode(cipherText);
  }


  public static String getPublickeyAndEncrypt(String key, String text){
    byte[] keyBytes = null;
    try {
        keyBytes = Base64.decode(key);
    } catch (UnsupportedEncodingException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = null;
    try {
        keyFactory = KeyFactory.getInstance(ALGORITHM);
    } catch (NoSuchAlgorithmException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

    Key publicKey = null;
    try {
        publicKey = keyFactory.generatePublic(x509KeySpec);
    } catch (InvalidKeySpecException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

//      ObjectInputStream inputStream = null;
      String cipherText = null;
      // Encrypt the string using the public key
      try {
//        inputStream = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
//        final PublicKey publicKey = (PublicKey) inputStream.readObject();
        cipherText = RSAencrypt(text, publicKey);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     return cipherText;
  }

public static byte[][] splitByteArray(byte[] buf, int size)
  {
      byte[][] ret = null;
      if(null == buf || buf.length <= 0 || size <= 0)
      {
          return ret;
      }

      int bufLen = buf.length;
      int beginIndex = 0;
      int endIndex = 0;
      int mod = bufLen%size;
      int retSize = (mod == 0) ? (bufLen/size) : (bufLen/size + 1);
      ret = new byte[retSize][];

      if(mod == 0)
      {
          for(int i = 0 ;i < retSize; i++)
          {
              beginIndex = endIndex;
              endIndex += size;
              ret[i] = Arrays.copyOfRange(buf, beginIndex, endIndex);
          }
      }
      else
      {
          for(int i= 0; i < retSize; i++)
          {
              beginIndex = endIndex;
              if(i < retSize - 1)
              {
                  endIndex += size;
              }
              else
              {
                  endIndex += mod;
              }
              ret[i] = Arrays.copyOfRange(buf, beginIndex, endIndex);
          }
      }
      return ret;
  }
  
  public static String RSAdecrypt(String text, Key key) {
      StringBuffer sb = new StringBuffer();
      try {
        // get an RSA cipher object and print the provider
        final Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");

        // decrypt the text using the private key
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] encodedStr = Base64.decode(text);
        byte[][] temp = splitByteArray(encodedStr, 128);
        for(int i = 0; i < temp.length; i++)
        {
            byte[] temp2 = cipher.doFinal(temp[i]);
            sb.append(new String(temp2).trim());
        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }

      return sb.toString();
    }


public static String getPrivateKeyAndDecrypt(String key, String text){
    byte[] keyBytes = null;
    try {
        keyBytes = Base64.decode(key);
    } catch (UnsupportedEncodingException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

    PKCS8EncodedKeySpec  x509KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = null;
    try {
        keyFactory = KeyFactory.getInstance(ALGORITHM);
    } catch (NoSuchAlgorithmException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

    Key privateKey = null;
    try {
        privateKey = keyFactory.generatePrivate(x509KeySpec);
    } catch (InvalidKeySpecException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

//      ObjectInputStream inputStream = null;
      String plainText = null;
      // Encrypt the string using the public key
      try {
//        inputStream = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
//        final PublicKey publicKey = (PublicKey) inputStream.readObject();
        plainText = RSAdecrypt(text, privateKey);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     return plainText;
}

}
