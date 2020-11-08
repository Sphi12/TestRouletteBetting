# ms-invoice-retrievechargeofinvoice

Pasos para despliegue.

1. Compilación.
2. Creacion de imagen.
3. Creacion de ConfigMap (Sinconizacion con proyecto de despliegue "ms-cluster)
4. Despliegue de servicio.

# Compilación

mvn clean install

Genera el componente "ms-customer-modify-charge-exp.jar"

Clase que inicia: ec.otecel.modifyCharge.MsCustomerModifyChargeExpApplication

Protocolo: HTTP

Puerto interno: 8080

# Creación de imagen

sudo docker build -t ms-middleware-customer-modify-charge:1.0.0 .

# Create the configmap

kubectl create configmap ms-customer-modify-charge-configmap --from-file=application.properties --namespace=ms-middleware

# Crear carpeta de logs.

	mkdir -p /datos/logs/ms/ms-customer-modify-charge

# Adicionar logs a filebeat (ELK).

	Editar 
	
	sudo vim /etc/filebeat/filebeat.yml
	
	- /datos/logs/ms/ms-customer-modify-charge/LogExec.log
	

# Despliegue de Service y Deployment


kubectl apply -f k8s-ms-customer-modify-charge.yaml


# Eliminacion de Service y Deployment

kubectl delete deployment ms-customer-modify-charge-deployment --namespace=ms-middleware

kubectl delete service ms-customer-modify-charge-service --namespace=ms-middleware

kubectl delete configmaps ms-customer-modify-charge-configmap --namespace=ms-middleware

# Verificación de despliegue

	kubectl get all --all-namespaces
	kubectl get services --namespace=ms-middleware
	kubectl get deployments --namespace=ms-middleware
	kubectl get pods --namespace=ms-middleware -o wide
