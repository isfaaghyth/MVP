package isfaaghyth.app.mvp.network;

import isfaaghyth.app.mvp.model.EmployeeModel;
import isfaaghyth.app.mvp.model.LoginModel;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public interface NetworkServices {

    @FormUrlEncoded @POST("/api/login.php")
    Observable<LoginModel> postLogin (
            @Field("email") String email,
            @Field("password") String password);

    @GET("/")
    Observable<EmployeeModel> getEmployee();
}
