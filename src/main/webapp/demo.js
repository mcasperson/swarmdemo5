var Topology = topology();

var topologyDiv = document.getElementById("topology");

// listen for changes to the service topology
// and update our component on change
Topology.onTopologyChange(function(topology) {
    var topologyTable = "<table>";

    for (var property in topology) {
        if (topology.hasOwnProperty(property)) {
            topologyTable += "<tr>";

            topologyTable += "<td>";
            topologyTable += property;
            topologyTable += "</td>";

            topologyTable += "<td>";
            for (var i = 0; i < topology[property].length; ++i) {
                topologyTable += topology[property][i].endpoint + " ";
            }
            topologyTable += "</td>";

            topologyTable += "</tr>";
        }
    }

    topologyTable += "</table>";

    topologyDiv.innerHTML = topologyTable;
});