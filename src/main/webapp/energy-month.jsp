<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<h2 class="center-vertical-horizontal">Energy Management System</h2>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<%
    String scheme = request.getScheme();             // http hoặc https
    String serverName = request.getServerName();     // Tên host (ví dụ: localhost)
    int serverPort = request.getServerPort();        // Cổng (ví dụ: 8080)
    String contextPath = request.getContextPath();   // Context path của ứng dụng (ví dụ: /myapp)

    // Kết hợp thành URL đầy đủ
    String baseURL = scheme + "://" + serverName + ":" + serverPort + contextPath;
%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="<%= baseURL %>/index.jsp">Energy Consumption By Year</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<%= baseURL %>/energy-month.jsp">Energy Consumption By Month</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%= baseURL %>/energy-location.jsp">Energy Consumption By Location</a>
      </li>

    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    </form>
  </div>
</nav>

</head>
<body>
 <label for="cars">Choose a year:</label>

<select name="cars" id="cars">
  <option value="2024">2024</option>
  <option value="2023">2023</option>
  <option value="2022">2022</option>
  <option value="2021">2021</option>
   <option value="2020">2020</option>
</select>

<canvas id="myPieChart" width="400" height="400" style="margin: auto;"></canvas>
<canvas id="myBarChart" width="500" height="500" style="margin: auto;"></canvas>
<script>


    async function fetchData() {
                const response = await fetch('http://localhost:8080/ems/energy-consumption-month'); // Thay thế bằng URL API của bạn
                const data = await response.json();
                return data;
            }
    const colors = ['#ef9a9a',
            '#e1bee7',
            '#e91e63',
            '#ec407a',
            '#f44336',
            'red',
            'blue',
            'green',
            'orange',
            'purple',
            'yellow',
            '#f06292'];
            // Hàm để vẽ biểu đồ
    async function renderChart() {
                const apiData = await fetchData();

                // Giả sử apiData là một mảng các đối tượng với các thuộc tính "label" và "value"
                const labels = apiData.map(item => item.month); // Lấy nhãn từ dữ liệu API
                const values = apiData.map(item => item.energyConsumption); // Lấy giá trị từ dữ liệu API

                const data = {
                                labels: labels,
                                datasets: [{
                                    label: 'Energy consumption',
                                    data: values,
                                    fill: false,
                                    borderColor: '#FFFFFF',
                                    backgroundColor: colors.slice(0, values.length),
                                    tension: 0.1
                                }]
                            };
                            const options = {
                                            responsive: false,
                                            plugins: {
                                                legend: {
                                                    labels: {
                                                        color: 'black'
                                                    }
                                                },
                                                tooltip: {
                                                    backgroundColor: 'rgba(0, 0, 0, 0.7)',
                                                    titleColor: 'white',
                                                    bodyColor: 'white'
                                                }
                                            },
                                            scales: {
                                                x: {
                                                    ticks: {
                                                        color: 'black'
                                                    }
                                                },
                                                y: {
                                                    ticks: {
                                                        color: 'black'
                                                    }
                                                }
                                            }
                                        };

                const pieconfig = {
                                type: 'pie', // Loại biểu đồ
                                data: data,
                                options

                            };
                 const barconfig = {
                                 type: 'bar', // Loại biểu đồ
                                 data: data,
                                 options: {
                                     responsive: false,
                                     plugins: {
                                         legend: {
                                             display: true,
                                         },
                                     },
                                     scales: {
                                         x: {
                                             beginAtZero: true,
                                         },
                                         y: {
                                             beginAtZero: true,
                                         }
                                     }
                                 },
                             };


  const myPieChart =  new Chart(document.getElementById('myPieChart'),pieconfig);
  const myBarChart =  new Chart(document.getElementById('myBarChart'),barconfig);

  }
  window.onload = renderChart;
</script>
</body>
</html>
