FROM nginx:1.15.8-alpine

COPY ./nginx.conf /etc/nginx/nginx.conf

copy ./public/*.html /usr/share/nginx/html/
copy ./public/*.css /usr/share/nginx/html/
#copy ./*.png /usr/share/nginx/html/
copy ./modules/*.js /usr/share/nginx/html/