package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.WeatherEntry;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private LiveData<List<WeatherEntry>> forecasts;


    public MainActivityViewModel(SunshineRepository repository) {
        this.forecasts = repository.getWeatherForecasts();
    }

    public LiveData<List<WeatherEntry>> getForecasts() {
        return forecasts;
    }
}
