import axios from 'axios';
import { useEffect } from 'react';
import { useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { Base_Url } from 'utils/request';

type ChartData = {
  series: number[];
  labels: string[];
}
function DonutChart() {

  const [chartData, setChartData] = useState<ChartData>({ series: [], labels: [] });

  useEffect(() => {
    axios.get(`${Base_Url}/sales/amount-by-seller`)
      .then(response => {
        const data = response.data as SaleSum[];
        const myLabels = data.map(x => x.sellerName);
        const mySeries = data.map(x => x.sum);
        setChartData({ series: mySeries, labels: myLabels });
      });
  }, [])

  // const mockData = {
  //   series: [477138, 499928, 444867, 220426, 473088],
  //   labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
  // }

  const options = {
    legend: {
      show: true
    }
  }
  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type='donut'
      height='240'
    />
  )
}
export default DonutChart;