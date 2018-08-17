Kubernetes:
===========

kubectl create -f kubernetes-pod.yaml
kubectl create -f kubernetes-deploy.yaml

# to update or upgrade any pod or coontainer image:
---------------------------------------------------
kubectl apply -f kubernetes-deploy.yaml

kubectl delete deployment kubernetes-deploy


#
#----------------------------------------
kubectl apply -f kubernetes-service.yaml


kubectl get pods

# View the Container’s logs:
#--------------------------
  kubectl logs marketplace.com


# Get a shell into the Container that is running in your Pod:
#-----------------------------------------------------------
  kubectl exec -it marketplace.com -- sh


# Display logfile for a container in a pod:
#------------------------------------------
kubectl logs -f -c discovery-server marketplace.com