import React from 'react';
import PieChart from "../components/PieChart";
import NavBar from '../components/NavigationBar';
import Card from '../components/Card';
import { Grid, GridItem, VStack } from '@chakra-ui/react';

function Dashboard() {
    return (
        <div>
            {/* Sidebar */}
            <NavBar />

            {/* User Greeting */}
            <div style={{ paddingLeft: '280px', overflowX: 'hidden' }}>
                <h1 style={{ fontSize: '2rem', color: 'black', textAlign: 'left', paddingLeft: '60px', marginTop: '20px' }}>
                    <b>Hello, Khushi</b>
                </h1>
                <h3 style={{ color: 'darkgray', textAlign: 'left', paddingLeft: '60px', marginTop: '0px' }}>
                    Today is Sunday February 9th, 2025
                </h3>
            </div>

            {/* Statistic Cards */}
            <div style={{ paddingLeft: '330px', overflowX: 'hidden' }}>
                <Grid
                    templateColumns="repeat(3, 1fr)"
                    gap="10"
                    paddingTop='40px'
                    justifyItems="start"
                >
                    <GridItem>
                        <Card
                            style={{
                                backgroundColor: "#101322", // Custom background for this card
                                width: '800px', // Ensure the card doesn't exceed a certain width
                                height: '325px',
                                display: 'flex',
                                justifyContent: 'flex-start',
                                alignItems: 'flex-start',
                                padding: '20px'
                            }}
                        >
                            <h1 style={{ textAlign: 'left', color: 'white', fontSize: '1.5rem' }}>2025 Spending</h1>
                        </Card>
                    </GridItem>
                    <GridItem>
                        <Card
                            style={{
                                backgroundColor: "#7eb75d", // Custom background for this card
                                width: '475px',
                                height: '325px',
                                display: 'flex',
                                justifyContent: 'flex-start',
                                alignItems: 'flex-start',
                                paddingRight: '70px'
                            }}
                        >
                            <VStack alignItems='flex-start'>
                                <h1 style={{ textAlign: 'left', color: 'white', fontSize: '1.5rem' }}>Net 2025 Profits</h1>
                                <h2 style={{ textAlign: 'left', color: 'lightgray', fontSize: '1rem', paddingRight: '-10px'}}>Current Risk Level: 3</h2>
                            </VStack>
                        </Card>
                    </GridItem>
                </Grid>
                <Grid
                    templateRows="repeat(1, 1fr)"
                    gap="10"
                    paddingTop='40px'
                >
                    <GridItem>
                        <Card
                            style={{
                                backgroundColor: "#D9BDA8",
                                width: '100%',
                                maxWidth: '1320px', // Max width for responsiveness
                                height: '250px'
                            }}
                        >
                            <h1>Dashboard Content</h1>
                        </Card>
                    </GridItem>
                </Grid>
            </div>
        </div>
    );
}

export default Dashboard;
