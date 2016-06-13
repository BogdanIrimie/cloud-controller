# cloud-controller
A cloud controller that is able to start preemptive virtual machines and virtual machines in order to reduce cost and offer QoS guarantees.

## Installation
In order to build and run controller you will need:
* JDK 1.5 or newer
* mvn 3.3.3 or newer

In order to run the locust tests you will need
* Python 2.7.11 or newer
* [locust.io](http://locust.io)

## Usage
The cloud-controller provides a command line interface.

### Supported arguments
|Short argument | Long argument | Description |
|---------------|---------------|-------------|
|-pvnum   |--pvm-number           |Specify the static number of preemptive virtual machines|
|-pvm-min |--pvm-min-num-replicas |Specify the minimum number of preemptive virtual machines|
|-pvm-max |--pvm-max-num-replicas |Specify the maximum number of preemptive virtual machines|
|-vmnum   |--vm-number            |Specify the static number of virtual machines|
|-vm-min  |--vm-min-num-replicas  |Specify the minimum number of virtual machines|
|-vm-max  |--vm-max-num-replicas  |Specify the maximum number of virtual machines|

E.g. `java -jar client-controller.jar`
