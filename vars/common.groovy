def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       sh 'echo validate, complie and perform UnitTesting'
       sh "echo UnitTesting must pass for artifacts to be created"
       sh 'mvn clean package'
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       sh "mvn sonar:sonar"
       sh 'echo code quality analysis completed'
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       sh 'mvn deploy'
       sh 'echo artifacts uploaded successfully'
     }
}
