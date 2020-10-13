package learn.spring.cloud.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 邝明山
 * on 2020/10/9 10:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public static JsonResult success(){
        return new JsonResult(200,"success",null);
    }
    public static JsonResult success(Object Data){
        return new JsonResult(200,"success",Data);
    }
    public static JsonResult success(String message,Object Data){
        return new JsonResult(200,message,Data);
    }
    public static JsonResult success(Integer code,String message,Object Data){
        return new JsonResult(code,message,Data);
    }
    public static JsonResult error(){
        return new JsonResult(500,"UnKnow",null);
    }
    public static JsonResult error(Object data){
        return new JsonResult(500,"UnKnow",data);
    }
    public static JsonResult error(String message){
        return new JsonResult(500,message,null);
    }
    public static JsonResult error(String message,Object data){
        return new JsonResult(500,message,data);
    }
    public static JsonResult error(Integer code,String message,Object data){
        return new JsonResult(code,message,data);
    }
    public static JsonResult notFound(){
        return new JsonResult(404,"not found",null);
    }
    public static JsonResult notFound(String message){
        return new JsonResult(404,message,null);
    }
    public static JsonResult notFound(Object data){
        return new JsonResult(404,"not found",data);
    }
    public static JsonResult notFound(String message,Object data){
        return new JsonResult(404,message,data);
    }
    public static JsonResult notFound(Integer code,String message,Object data){
        return new JsonResult(code,message,data);
    }

}
