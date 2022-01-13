FROM eclipse-temurin:11
RUN apt-get update && apt-get -y upgrade
RUN apt-get install -y inotify-tools dos2unix
ENV HOME=/app
ENV SPRING_APPLICATION_PORT=8030
ENV SPRING_DEBUGGER_PORT=5005
EXPOSE $SPRING_APPLICATION_PORT
EXPOSE $SPRING_DEBUGGER_PORT
EXPOSE 35729
RUN mkdir -p $HOME
WORKDIR $HOME
CMD ["sh","run.sh"]