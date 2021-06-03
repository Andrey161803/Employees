package com.andrewsapp.employeeslist;

import android.app.Application;
import android.util.Log;

import com.andrewsapp.employeeslist.api.ApiFactory;
import com.andrewsapp.employeeslist.database.AppDatabase;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private final AppDatabase db;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainViewModel(@NonNull Application application) {
        super(application);

        db = AppDatabase.getInstance(application);
        loadData();
    }

    private void loadData() {
        Disposable disposable = ApiFactory.apiService.getDataModel()
                .delaySubscription(5, TimeUnit.SECONDS)
                .repeat()
                .retry()
                .subscribeOn(Schedulers.io())
                .subscribe(response -> {
                    db.employeesInfoDao().deleteAllEmployees();
                    db.employeesInfoDao().insertEmployees(response.getCompany().getEmployees());
                    Log.d("TEST_LOADING_EMPLOYEES", "Success!");
                });

        compositeDisposable.add(disposable);
    }

    @Override
    public void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

}
