package isfaaghyth.app.mvp.network;

import isfaaghyth.app.mvp.util.Const;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by isfaaghyth on 6/17/17.
 */

public class NetworkClient {

    public static Retrofit request() {
        return new Retrofit.Builder()
                .baseUrl(Const.MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
