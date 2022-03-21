String basePath = 'prod'
pipelineJob("$basePath/test password") {
    properties {
        githubProjectUrl('git@github.ibm.com:Observability/ATracker-deploy.git/')
        buildDiscarder {
            strategy {
                logRotator {
                    daysToKeepStr("-1")
                    numToKeepStr("200")
                    artifactDaysToKeepStr("-1")
                    artifactNumToKeepStr("-1")
                }
            }
        }
    }
    parameters {
        passwordParameterDefinition{name("my-pass"), description("my-pass description")}
        // stringParam('IMAGE_BUILD_TAG', '', 'ImageName:CommitID')
        // stringParam('IMAGE_RELEASE_TAG', '', 'repourl/ImageName:CommitID')
        // stringParam('DEPLOYMENT', 'prod_au-syd', '')
    }
    description()
    keepDependencies(false)
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("https://github.com/akhiljain23/jenkins-dsl-scripts.git")
                    }
                    branch("*/master")
                }
            }
            scriptPath("tools/test-password.groovy")
        }
    }
}
