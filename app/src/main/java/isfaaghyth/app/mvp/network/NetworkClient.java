package isfaaghyth.app.mvp.network;

import isfaaghyth.app.mvp.util.Const;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by isfaaghyth on 6/17/17.
 * NetworkClient untuk melakukan request terhadap url main.
 * memiliki method static request() yang nantikan dapat digunakan oleh class yang membutuhkan
 * tanpa inisialisasi objek.
 */

public class NetworkClient {

    public static Retrofit request() {
        return new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
