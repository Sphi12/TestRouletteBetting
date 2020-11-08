# ------------------------------------------------------------------------
#
# Imagen de microservicio - Telefonica
# 
# Directorio de ubicacion de todos los microservicio /opt/ms/<NOMBRE>
#
# docker build -f Dockerfile -t ms-customer-modify-charge-QA:1.0.0 .
#
# ------------------------------------------------------------------------

FROM openjdk:8
MAINTAINER devops@telefonica.com.ec

RUN mkdir -p /opt/ms/ms-customer-modify-charge

WORKDIR /opt/ms/ms-customer-modify-charge

# --------------------------------
# Copy scripts, packages & plugins
# --------------------------------
COPY target/ms-customer-modify-charge-exp.jar /opt/ms/ms-customer-modify-charge/
#COPY application.properties /opt/ms/ms-customer-modify-charge

#-----------------------
# Expose container ports
# ----------------------
EXPOSE 8080

ENTRYPOINT java -jar /opt/ms/ms-customer-modify-charge/ms-customer-modify-charge-exp.jar
