package com.irdeto.securesdk;

class ISFResult {
    public int errorCode;
    public Object value;
    public ISFResult(int errorCode)
    {
        this.errorCode = errorCode;
    }
}

public class SecureSDKManager {
    private long isfCtx;
    
    private native ISFResult nIsfInitialize(String workPath, String bundlePath);

    private native ISFResult nIsfCleanup();

    private native ISFResult nIsfIsProvisioned();

    private native ISFResult nIsfGetProvisionRequest();

    private native ISFResult nIsfProvisionResponse(String response);

    private native ISFResult nIsfGetOpaqueData();

    private native ISFResult nIsfTokenSave(String[] ids, String[] tokens);

    private native ISFResult nIsfTokenOperate(String[] ids, String data);

    private native ISFResult nIsfStorePut(String id, byte[] data);

    private native ISFResult nIsfStoreGet(String id);

    private native ISFResult nIsfStoreDelete(String id);

    private native ISFResult nIsfEncrypt(String plainData);

    private native ISFResult nIsfDecrypt(String cipherData);

    private native ISFResult nIsfCryptoOperate(String type, String keyId, byte[] iv, byte[] data);

    private native ISFResult nIsfSecurePassword(String plainPassword, String userName, String domainName,
            int iterationCount);

    public int isfInitialize() {
        return 0;
    }

    public int isfCleanup() {
        return 0;
    }

    public boolean isfIsProvisioned() {
        return true;
    }

    public String isfGetProvisionRequest() {
        return null;
    }

    public int isfProvisionResponse(String response) {
        return 0;
    }

    public String isfGetOpaqueData() {
        return null;
    }

    public int isfTokenSave(String[] ids, String[] tokens) {
        return 0;
    }

    public String isfTokenOperate(String[] ids, String data) {
        return null;
    }

    public int isfStorePut(String id, byte[] data) {
        return 0;
    }

    public byte[] isfStoreGet(String id) {
        return null;
    }

    public int isfStoreDelete(String id) {
        return 0;
    }

    public String isfEncrypt(String plainData) {
        return null;
    }

    public String isfDecrypt(String cipherData) {
        return null;
    }

    public byte[] isfCryptoOperate(String type, String keyId, byte[] iv, byte[] data) {

        return null;
    }

    public byte[] isfSecurePassword(String plainPassword, String userName, String domainName, int iterationCount) {

        return null;
    }
    
}
