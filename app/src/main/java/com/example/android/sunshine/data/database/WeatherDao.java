package com.example.android.sunshine.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weather);

//    @Query("SELECT * FROM weather WHERE date = :date")
//    WeatherEntry getWeatherByDate(Date date);

    @Query("SELECT * FROM weather WHERE date = :date")
    LiveData<WeatherEntry> getWeatherByDate(Date date);

    @Query("SELECT count(*) FROM weather WHERE date(date,'unixepoch', 'localtime') between date('now') and date('now','+14 day')")
    int countAllFutureWeather();

    //@Query("DELETE FROM weather WHERE date(date,'unixepoch', 'localtime') < :date")
    @Query("DELETE FROM weather WHERE date < :date")
    void deleteDataOlderThan(Date date);

    @Query("SELECT id,weatherIconId,date,min,max FROM weather WHERE date >= :date")
    LiveData<List<ListViewWeatherEntry>> getWeatherForecastsAfter(Date date);
}
