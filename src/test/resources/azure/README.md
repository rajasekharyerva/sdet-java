# Set Up Azure
### Create an Azure Account:
[Azure Portal](https://portal.azure.com/)
### Install Azure CLI on macOS
    Install with Homebrew
        brew update && brew install azure-cli
## Create an Azure App Service
### Create a Resource Group:
```
az group create --name EmployeeAppGroup --location eastus
```
    In the left-hand menu, click Resource groups.
    Click + Create at the top of the page.
    Fill in the details:
        Subscription: Select your subscription.
        Resource group name: Provide a unique name (e.g., EmployeeAppGroup).
        Region: Choose a location (e.g., East US).
    Click Review + Create, and then Create.
### Create an App Service Plan
```
az appservice plan create --name EmployeeAppPlan --resource-group EmployeeAppGroup --sku B1 --is-linux
```
    In the search bar, type "App Service Plans" and select it.
    Click "Create".
    Enter the following details:
    Subscription: Select your subscription.
    Resource Group: Select EmployeeAppResourceGroup.
    Name: e.g., EmployeeAppPlan.
    Operating System: Choose Linux.
    Region: Select the same region as the resource group.
    Pricing Tier: Select a suitable pricing tier (e.g., B1 for a basic plan).
    Click "Review + Create", then "Create".
### Create a Web App
    In the search bar, type "App Services" and select it.
    Click "Create".
    Enter the following details:
    Subscription: Select your subscription.
    Resource Group: Select EmployeeAppResourceGroup.
    Name: e.g., EmployeeBackendApp.
    Publish: Choose Code.
    Runtime Stack: Select Java 11 (or the Java version of your app).
    Operating System: Choose Linux.
    Region: Select the same region as the resource group.
    App Service Plan: Select EmployeeAppPlan.
    Click "Review + Create", then "Create".
### Deploy the Spring Boot Application
    Navigate to your web app by selecting App Services > EmployeeBackendApp.
    In the Overview tab, click "Deployment Center".
    Select Deployment Source:
    Source: Choose Local Git or GitHub, depending on your preference.
    Follow the instructions:
    For Local Git:
    Copy the Git URL provided.
    Push your Spring Boot JAR to the repository from your local system.
    For GitHub:
    Authenticate with GitHub and select your repository containing the Spring Boot application.
    Azure will automatically deploy the application after you configure it.
### Test Your Application
    Navigate back to the Overview tab of your web app.
    Copy the URL (e.g., https://employeebackendapp.azurewebsites.net).
    Open the URL in your browser or test it using Postman.
### View Logs - Access the Logs in Azure Portal:
    Go to the App Service you created in the Azure Portal.
    Navigate to Monitoring > Log Stream.
    The logs will show:
    Deployment progress.
    Whether the application started successfully.
    Any errors or output from the Spring Boot application.
### Monitor Application
```az webapp log tail --name <your-app-name> --resource-group <resource-group-name>
```
    Enable Application Insights for monitoring:
    Go to Application Insights in the left menu of your app.
    Click Enable and follow the prompts.
    Use the insights dashboard to view metrics, logs, and performance data.

### Enable Comprehensive Logging
    Go to App Service in Azure Portal:
        Navigate to your App Service instance in the Azure Portal.
    Enable Diagnostics Logging:
        Go to App Service Logs in the left menu.
        Configure the following:
    Application Logging (Filesystem): Turn it On.
        Web Server Logging: Set it to Filesystem.
        Retention Period: Set a retention period (e.g., 3 days).
        Detailed Error Messages: Turn it On (optional, for debugging HTTP errors).
        Failed Request Tracing: Turn it On (optional, for tracking failed requests).
    Save Changes:
        Click Save to apply the settings.