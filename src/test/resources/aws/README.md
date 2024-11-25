# Step-by-Step Guide to Set Up an EC2 Instance
## Step 1: Log in to AWS
    Log in to your AWS Management Console: AWS Console.
    Navigate to the EC2 Dashboard by searching for EC2 in the AWS search bar.
## Step 2: Launch an EC2 Instance
    Click "Launch Instances":
        Go to the EC2 dashboard and select "Launch Instances".
    Name and Tags:
        Provide a name for your instance (e.g., MyBackendApp).
    Select an Amazon Machine Image (AMI):
        Choose Amazon Linux 2 AMI (Free Tier Eligible).
    Select an Instance Type:
        Choose the t2.micro instance type, which is eligible for the free tier.
    Key Pair:
        Create a new key pair or use an existing one:
            If creating: Name your key pair, select the .pem format, and download it. This key will be used for SSH access.
    Network Settings:
        VPC and Subnet: Use the default VPC and subnet.
        Firewall (Security Groups):
            Allow SSH (port 22) from your IP (default is "My IP").
            Allow HTTP (port 80) and/or HTTPS (port 443) to make your application accessible.
    Configure Storage:
        Use the default size of 8 GiB for general-purpose (gp2) volumes.
    Review and Launch:
        Review all configurations and click Launch Instance.
## Step 3: Access the EC2 Instance
    Get the Public IP:
        From the EC2 dashboard, find your instance and copy the public IPv4 address.
    SSH into the Instance:
        Open a terminal and navigate to the directory where your .pem key is stored.
        Change the key’s permissions:
            chmod 400 <key-pair-name>.pem
        Connect to the instance using SSH:
            ssh -i <key-pair-name>.pem ec2-user@<public-ip>
            curl http://localhost:8082
    Install Dependencies on EC2: SSH into the EC2 instance and install Java and Maven:
        sudo yum update -y
        sudo yum install java-17-amazon-corretto -y
        sudo yum install git -y
        sudo yum install maven -y
        git clone https://github.com/rajasekharyerva/spring-demo-employee.git
        cd <spring-demo-employee>
        mvn package
        java -jar target/<employee-service>-0.0.1-SNAPSHOT.jar
        pwd
        ls -a
        sudo cat /var/log/cloud-init-output.log
        scp -i aws-keypair.pem ec2-user@35.154.201.212:/var/log/cloud-init-output.log /Users/rajasekharreddyyerva/logs/
        sudo cat /var/log/cloud-init.log
        scp -i /path/to/your-key.pem ec2-user@34.234.56.78:/var/log/cloud-init.log /Users/rajasekharreddyyerva/logs/

        
    Verify the application is accessible at http://<EC2-Public-IP>:8081/<employees>
## Step 4: Create a Launch Template from an Existing Instance
    Go to the EC2 Dashboard:
        Log in to your AWS Management Console and navigate to the EC2 Dashboard.
    Select Your Existing Instance:
        Find the EC2 instance you want to replicate.
    Actions > Create Template from Instance:
        Click on the instance, then go to Actions > Create Template from Instance.
    Fill in Template Details:
        Provide a Template Name (e.g., MyEmployeeAppTemplate) and an optional Description.
        Review or customize the settings that you want to save:
            Instance type
            AMI
            Security groups
            Key pair
            User data (if any startup scripts are configured)
    Save the Template:
        Click Create Template.
## Step 5: Launch a New Instance Using the Template
    Navigate to Launch Templates:
        From the EC2 Dashboard, click on Launch Templates in the left-hand menu.
    Select the Template:
        Find the previously created template and select it.
    Launch Instance:
        Click Actions > Launch Instance from Template.
        Customize settings (if needed) and launch the new instance.
## Step 3: (Optional) Add a Startup Script to Automate App Setup
    If your application requires specific setup (e.g., downloading a JAR file, starting the app), you can include a User Data Script in the launch template. For example:
        #!/bin/bash
        sudo yum update -y
        sudo yum install java-11-amazon-corretto -y
        cd /home/ec2-user
        wget https://example.com/path-to-your-employee-app.jar
        java -jar employee-app.jar
    This script runs automatically whenever an instance is launched from the template.