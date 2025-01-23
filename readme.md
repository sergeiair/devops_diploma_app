
### ARGO CD SETUP
#### kubectl create namespace argocd
#### kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml

### INGRES CONTROLLER
#### kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml

### INGRESS-NGINX CTRL
#### kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/aws/deploy.yaml

### ALLOW HTTP FOR ARGO CD SERVER
#### kubectl edit configmap argocd-cmd-params-cm -n argocd

##### data:  
#####   server.insecure: "true"
##### kubectl rollout restart deployment argocd-server -n argocd

### GET IPs
#### kubectl get svc -n ingress-nginx

### ARGO CD PW
#### kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath='{.data.password}' | base64 -d


### APP IPs
#### kubectl get svc java-web-server-service

