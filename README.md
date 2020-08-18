# App-for-viewing-photos
Android application. Using popular library

Приложение для просмотра фотографий.
Фотографии скачиваются с интернета, используя Retrofit с pixabay.com
При первой закачке ссылки на фото сохраняются в бд(Room), при дальнейшем пользовании фотографии загружаются уже из базы данных.

Используемая архитектура MVP
Приложение написано с использованием популярных библиотек: 
moxy, rxjava, retrofit, room, butterknife, leakcanary, dagger, glide.
