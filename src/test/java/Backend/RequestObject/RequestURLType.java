package Backend.RequestObject;

public class RequestURLType {

    public static String GET_ListUsers = "api/users?page=2";
    public static String GET_SingleUser = "api/users/2";
    public static  String GET_SingleUserNotFound = "api/users/23";
    public static String GET_DelayResponse = "api/users?page=2";
    public static String GET_ListResource = "api/unknown";
    public static String GET_ListSingleResource = "api/unknown/2";
    public static String GET_SingleResourceNotFound = "api/unknown/23";
    public static String POST_Books = "BookStore/v1/Books";
    public static String POST_Token = "Account/v1/GenerateToken";
    public static String POST_USER = "Account/v1/User";
    public static String PUT_PATCH_DELETE_USER = "api/users/2";


}
