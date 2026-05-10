package creationalPatterns.abstractFactoryPattern;


/**
 * Abstract Factory Pattern Says Factory of Factories
 *
 *
 *
 * You're building a deployment tool that provisions infrastructure resources across different cloud providers (AWS, Azure, GCP).
 * The client code shouldn't know or care which cloud it's deploying to — it just asks for a "storage stack"
 * and gets back a coherent set of resources that work together.
 *
 *
 * Requirements:
 * Each cloud provider's factory should produce a family of related products:
 *
 * A BlobStore (e.g., S3 Bucket, Azure Blob Container, GCS Bucket)
 * A Queue (e.g., SQS, Azure Service Bus, Pub/Sub)
 * A SecretVault (e.g., AWS Secrets Manager, Azure Key Vault, GCP Secret Manager)
 *
 *  Each product should expose a uniform interface (upload(), enqueue(), getSecret()) but internally simulate
 *  the provider-specific behavior — for instance, by printing the actual API call style or generating provider-specific
 *  resource identifiers (ARNs vs. resource IDs vs. project paths).
 *
 *
 * The key constraint: A client function like deployPipeline(factory) should work identically whether you pass it an
 * AWSFactory, AzureFactory, or GCPFactory, and the resources it creates must be from the same provider family
 * — you should never end up with an S3 bucket paired with an Azure queue.
 *
 *
 * Entities
 *---------------
 * CloudProviders  : deployPipeline(factory)
 *      - AWS
 *      - Azure
 *      - GCP
 * StorageStacks
 *   - BlobStore : upload()
 *      - S3
 *      - Azure Blob Container
 *      - GCS Bucket
 *   - Queue   : enqueue()
 *      - SQS
 *      - Azure Service Bus
 *      - Pub/Sub
 *   - SecretVault : getSecret()
 *      - Aws Secret Manager
 *      - Azure Key Vault
 *      - GCP Secret Manager
 *
 */


public class AbstractFactoryTest {
    static void main() {
        CloudProviderFactory awscloudProviderFactory = new AwsCloudProviderFactory();
        CloudProviderFactory azureCloudProviderFactory = new AzureCloudProviderFactory();
        CloudProviderFactory gcpCloudProviderFactory = new GCPCloudProviderFactory();

        Deployer.deploy(awscloudProviderFactory);
        Deployer.deploy(azureCloudProviderFactory);
        Deployer.deploy(gcpCloudProviderFactory);

    }
}





//---------------Client Deployer--------------------------------
class Deployer{
    public static void deploy(CloudProviderFactory factory){
        Queue queue = factory.createQueue();
        BlobStore blobStore = factory.createBlobStore();
        SecretVault secretVault = factory.createSecretValut();

        System.out.println("Deploying");

        secretVault.getSecret();
        queue.enqueue();
        blobStore.upload();

        System.out.println("------------------------------");
    }
}



interface CloudProviderFactory{
    Queue createQueue();
    BlobStore createBlobStore();
    SecretVault createSecretValut();
}





//-----------------Concrete Cloud Factories---------------------------------------
class AwsCloudProviderFactory implements CloudProviderFactory{
    @Override
    public Queue createQueue() {
        return new SQS();
    }

    @Override
    public BlobStore createBlobStore() {
        return new S3();
    }

    @Override
    public SecretVault createSecretValut() {
        return new AwsSecretManager();
    }
}
class AzureCloudProviderFactory implements CloudProviderFactory{
    @Override
    public Queue createQueue() {
        return new AzureServiceBus();
    }

    @Override
    public BlobStore createBlobStore() {
        return new AzureBlob();
    }

    @Override
    public SecretVault createSecretValut() {
        return new AzureKeyVault();
    }
}
class GCPCloudProviderFactory implements CloudProviderFactory{
    @Override
    public Queue createQueue() {
        return new PubSub();
    }

    @Override
    public BlobStore createBlobStore() {
        return new GCPBucket();
    }

    @Override
    public SecretVault createSecretValut() {
        return new GCPSecretManager();
    }
}











//-----------------Concrete AWS Products---------------------------------------
class S3 implements BlobStore{
    @Override
    public void upload() {
        System.out.println("Data upload to AWS S3");
    }
}

class SQS implements Queue{
    @Override
    public void enqueue() {
        System.out.println("Data Queued inside the AWS SQS");
    }
}


class AwsSecretManager implements SecretVault{
    @Override
    public void getSecret() {
        System.out.println("Get AWS Secrets");
    }

}






//-----------------Concrete Azure Products---------------------------------------
class AzureBlob implements BlobStore{
    @Override
    public void upload() {
        System.out.println("Data upload to Azure Blob Service");
    }
}

class AzureServiceBus implements Queue{
    @Override
    public void enqueue() {
        System.out.println("Data Queued inside the Azure Service Bus");
    }
}

class AzureKeyVault implements SecretVault{
    @Override
    public void getSecret() {
        System.out.println("Get Azure Secrets");
    }
}





//-----------------Concrete GCP Products---------------------------------------
class GCPBucket implements BlobStore{
    @Override
    public void upload() {
        System.out.println("Data upload to Azure Blob Service");
    }
}

class PubSub implements Queue{
    @Override
    public void enqueue() {
        System.out.println("Data Queued inside the GCP Pub sub");
    }
}

class GCPSecretManager implements SecretVault{
    @Override
    public void getSecret() {
        System.out.println("Get GCP Secrets");
    }
}







interface BlobStore {
     void upload();
}

interface Queue {
    void enqueue();
}

interface SecretVault {
    void getSecret();
}










