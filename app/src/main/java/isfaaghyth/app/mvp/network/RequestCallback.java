package isfaaghyth.app.mvp.network;

import android.util.Log;

import retrofit2.HttpException;
import rx.Subscriber;

/**
 * Created by isfaaghyth on 6/17/17.
 *
 * RequestCallback ini menggantikan callback default dari subscriber rx.
 * Mengapa diganti? disini kita membuat RequestCallback menjadi turujuan Subscriber, menjadi class abstract,
 * sekaligus menjadi generic class. Yang artinya, value yang dapat diterima RequestCallback ini
 * berupa objek dinamik, dapat disesuaikan yang kamu implementasikan nantinya.
 */

public abstract class RequestCallback<M> extends Subscriber<M> {

    /*
     * onSuccess
     * param: Generic class model
     * Hasil request ketika berhasil, akan disimpan oleh method ini.
     */
    public abstract void onSuccess(M model);

    /*
     * onFailure
     * param: string message
     * Ketika request terjadi kesalahan, maka pesan errornya akan disimpan di method ini.
     */
    public abstract void onFailure(String message);

    /*
     * onFinish
     * ketika proses request selesai, maka akan ditandakan oleh method onFinish() ini.
     */
    public abstract void onFinish();

    /*
     * Melakukan override terhadap method bawaan dari subscriber.
     * Kita melakukan pengecekan jika terjadi HttpException.
     * maka, pesan errornya akan dilempar ke method onFailure yang sudah buat disana.
     * Beserta dengan jika tidak ada error, maka request nya akan dilempar ke onFinish().
     */
    @Override public void onError(Throwable e) {
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            String message = httpException.getMessage();
            onFailure(message);
        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    /*
     * Method onNext() adalah bawaan dari subscriber.
     * method ini akan menampung jika request yang dilakukan berhasil.
     * Sangat ambigu namanya, makanya kita ganti menjadi onSuccess.
     * Oleh karena itu, kita tampung hasil onNext kedalam method onSuccess(<M>).
     */
    @Override public void onNext(M model) {
        onSuccess(model);
    }

    /*
     * Method onCompleted() merupakan method bawaan dari subscriber.
     * kita hanya mengganti method ini menjadi method onFinish().
     */
    @Override public void onCompleted() {
        onFinish();
    }

}
