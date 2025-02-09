import React, { useState } from 'react';
import { Pie } from 'react-chartjs-2';
import { Box, Text, Input, Button, Stack } from '@chakra-ui/react';
import { Chart as ChartJS, Title, Tooltip, Legend, ArcElement, CategoryScale } from 'chart.js';

// Register the necessary chart.js components
ChartJS.register(Title, Tooltip, Legend, ArcElement, CategoryScale);

const PieChart = () => {
  const [dataInput, setDataInput] = useState('');
  const [labelsInput, setLabelsInput] = useState('');
  const [pieData, setPieData] = useState({
    labels: ['Red', 'Blue', 'Yellow'], // Initial labels
    datasets: [
      {
        data: [300, 50, 100], // Initial data values
        backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56'], // Section colors
        hoverBackgroundColor: ['#FF6384', '#36A2EB', '#FFCE56'], // Hover colors
      },
    ],
  });

  // Handle the form submission to update the pie chart data
  const handleSubmit = () => {
    const newLabels = labelsInput.split(',').map((label) => label.trim());
    const newData = dataInput.split(',').map((data) => parseFloat(data.trim()));

    if (newLabels.length === newData.length) {
      setPieData({
        labels: newLabels,
        datasets: [
          {
            data: newData,
            backgroundColor: newLabels.map(() => getRandomColor()),
            hoverBackgroundColor: newLabels.map(() => getRandomColor()),
          },
        ],
      });
    }
  };

  // Helper function to generate random colors
  const getRandomColor = () => {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
  };

  return (
    <Box p={5} boxShadow="md" borderRadius="md">
      <Text fontSize="2xl" mb={4}>
        Input Data for Pie Chart
      </Text>
      
      {/* Form to input data */}
      <Stack spacing={3}>
        <Input
          placeholder="Enter labels (comma separated)"
          value={labelsInput}
          onChange={(e) => setLabelsInput(e.target.value)}
        />
        <Input
          placeholder="Enter data (comma separated)"
          value={dataInput}
          onChange={(e) => setDataInput(e.target.value)}
        />
        <Button colorScheme="teal" onClick={handleSubmit}>
          Update Chart
        </Button>
      </Stack>

      <Box mt={6}>
        <Pie data={pieData} />
      </Box>
    </Box>
  );
};

export default PieChart;