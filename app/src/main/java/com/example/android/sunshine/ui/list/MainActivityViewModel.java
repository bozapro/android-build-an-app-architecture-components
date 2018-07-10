package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.ListViewWeatherEntry;
import com.example.android.sunshine.data.database.WeatherEntry;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private LiveData<List<ListViewWeatherEntry>> forecasts;


    public MainActivityViewModel(SunshineRepository repository) {
        this.forecasts = repository.getCurrentWeatherForecasts();
    }

    public LiveData<List<ListViewWeatherEntry>> getForecasts() {
        return forecasts;
    }
}
