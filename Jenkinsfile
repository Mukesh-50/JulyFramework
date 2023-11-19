pipeline 
{
    agent any

    stages 
    {
        stage('Sample Job') 
        {
            steps 
            {
                build 'JulySampleJob'
            }
        }
        stage('Smoke Test') 
        {
            steps 
            {
                build 'SeleniumTestForFreelanceApplication'
                
            }
        }
         stage('Regression Test') 
        {
            steps 
            {
                build 'SeleniumTestForFreelanceApplicationWithTriggers'
            }
        }
    }
}
