package com.mg.mf;

enum ISFErrorType
{
    /**
     * A license was successfully updated in the DRM system.
     *
     * This occurs when a license arrives from a server and has been successfully ingested.
     *
     * \note This does not necessarily mean the content can be played back.  If the license
     *       server issued a valid license, but it does not correspond to the content that
     *       is being requested, the content will not be able to decrypt and you will
     *       get a different error.
     */
    //Manager, value range 0x0 - 0xff
    ISF_MGR_NONE(0, "no error"),
    ISF_MGR_UNKNOWN(1, "Unknown Error"),
    ISF_MGR_INVALID_PARAMETER(2, "Parameter is invalid"),
    ISF_MGR_ERROR_INT(3, "Initialization failed"),
    ISF_MGR_ALREADY_INITIALIZED(4, "Already initialized"),
    ISF_MGR_NOT_PROVISIONED(5, "Not provisioned"),
    ISF_MGR_INVALID_PROVISION_RESPONSE(6, "Invalid provision response"),
    ISF_MGR_NOT_SUPPORTED(7, "NOT supported"),
    ISF_MGR_NO_PERMISSION(8, "NO permission"),
    ISF_MGR_TOKEN_SAVE_FAILED(9, "Token Save Failed"),
    ISF_MGR_ROOTDETECTED(10, "Root Detected"),

    //Credential, value range 0x100 - 0xff
    ISF_CRD_NONE(0x100, "no error"),
    
    //Individualization serve, value range 0x200 - 0xff
    ISF_IS_NONE(0x200, "no error"),
    ISF_IS_HELP(0x201, "Invalid individual helper"),
    ISF_IS_UUID(0x202, "Invalid UUID of SS2"),
    ISF_IS_CTXP(0x203, "Invalid preconfig context"),
    ISF_IS_CTX1(0x204, "Invalid store context of ss1"),
    ISF_IS_CTX2(0x205, "Invalid store context of ss2"),
    ISF_IS_PTXT(0x206, "Invalid plain provision request"),
    ISF_IS_CNFP(0x207, "Invalid preconfig pub key"),
    ISF_IS_JWEC(0x208, "Invalid JWE compact data of response"),
    ISF_IS_JWSC(0x209, "Invalid JWS compact data of response"),
    ISF_IS_ESTR(0x20A, "Failed to decode response"),
    ISF_IS_HTTP(0x20B, "Failed to send http request"),
    ISF_IS_RESP(0x20C, "Failed to get response from IS server"),
    ISF_IS_JFMT(0x20D, "Invalid JSON format of response"),
    ISF_IS_JDAT(0x20E, "Invalid JSON sdata object"),
    ISF_IS_JVAL(0x20F, "Invalid JSON sdata value"),
    ISF_IS_JWSS(0x210, "Invalid JWS signature"), 
    ISF_IS_ECCD(0x211, "Failed to decoding ECC KW body"),
    ISF_IS_SAV1(0x212, "Invalid parameters (data or path) of saving ss2"),
    ISF_IS_SAV2(0x213, "Invalid data length of saving ss2"),
    ISF_IS_SAV3(0x214, "Failed to open saving file"),
    ISF_IS_SAV4(0x215, "Failed to writing data into file"),

    //Communication servic, value range 0x300 - 0xff
    ISF_CS_NONE(0x300, "no error"),
    ISF_CS_DECRYPT_FAILED(0x301, "decrypt failed"),
    ISF_CS_ENCRYPT_FAILED(0x302, "encrypt failed");
    
    //Storag, value range 0x400 - 0xff
    //to be added


    //////////////////////////////////////////////////
    private int type;
    private String message;

    ISFErrorType(int type, String message)
    {
            this.type = type;
            this.message = message;
    }

    /**
     * Gets the event's type value
     *
     * @return An integral value that represents the event's type.
     */
    public int getValue()
    {
        return type;
    }

    public static ISFErrorType fromValue(int type)
    {
        for (ISFErrorType eventType: ISFErrorType.values())
        {
            if (eventType.getValue() == type)
                return eventType;
        }
        throw new IllegalArgumentException("Invalid MediaEventType:"+type);
    }

    /**
     * Gets the event's message string
     *
     * @return A String that contains the message value associated with the event.
     */
    public String toString()
    {
        return this.message;
    }
}

enum NativeCode{
    ISF_OK(0),
    ISF_ERROR(1);
    int code;
    NativeCode(int code)
    {
        this.code = code;
    }
}

public class TestCommon {
    
    public static void main(String[] args) {

       Boolean b = Boolean.valueOf("true");
       System.out.println(b);
    }

}
