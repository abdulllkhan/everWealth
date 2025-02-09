import React from 'react';
import PieChart from "../components/PieChart";
import NavBar from '../components/NavigationBar';
import Card from '../components/Card';
import { Center, Grid, GridItem, HStack } from '@chakra-ui/react';
import { StackSeparator } from "@chakra-ui/react"

function Transactions() {
    return (
        <div>
            {/* Sidebar */}
            <NavBar />

            {/* User Greeting */}
            <div style={{ paddingLeft: '280px', overflowX: 'hidden' }}>
                <h1 style={{ fontSize: '2rem', color: 'black', textAlign: 'left', paddingLeft: '60px', marginTop: '20px' }}>
                    <b>Transactions</b>
                </h1>
                <h3 style={{ color: 'darkgray', textAlign: 'left', paddingLeft: '60px', marginTop: '0px' }}>
                    Statement Period: 1/27/25 - 2/27/25
                </h3>
            </div>

            {/* Statistic Cards */}
            <div style={{ paddingLeft: '330px', overflowX: 'hidden' }}>
                <GridItem style={{ paddingTop: '30px' }}>
                        <Card
                            style={{
                                backgroundColor: "#d1cfcf",
                                width: '100%',
                                maxWidth: '1320px', // Max width for responsiveness
                                height: '50px'
                            }}
                        >
                            <HStack separator={<StackSeparator borderColor="blackAlpha.300" />} gap='100px' justify='center' align='center'>
                                <h1>Vendor Name/ID</h1>
                                <h1>Date</h1>
                                <h1>Amount</h1>
                                <h1>Amount Invested</h1>
                                <h1>Status</h1>
                            </HStack>
                        </Card>
                    </GridItem>
                <Grid
                    templateRows="repeat(4, 1fr)"
                    gap="4"
                    paddingTop='25px'
                >
                    <GridItem>
                        <Card
                            style={{
                                backgroundColor: "#f2f0f0",
                                width: '100%',
                                maxWidth: '1320px', // Max width for responsiveness
                                height: '120px'
                            }}
                            borderColor="black"
                        >
                            <h1>Dashboard Content</h1>
                        </Card>
                    </GridItem>
                    <GridItem>
                        <Card
                            style={{
                                backgroundColor: "#f2f0f0",
                                width: '100%',
                                maxWidth: '1320px', // Max width for responsiveness
                                height: '120px'
                            }}
                        >
                            <h1>Dashboard Content</h1>
                        </Card>
                    </GridItem>
                    <GridItem>
                        <Card
                            style={{
                                backgroundColor: "#f2f0f0",
                                width: '100%',
                                maxWidth: '1320px', // Max width for responsiveness
                                height: '120px'
                            }}
                        >
                            <h1>Dashboard Content</h1>
                        </Card>
                    </GridItem>
                    <GridItem>
                        <Card
                            style={{
                                backgroundColor: "#f2f0f0",
                                width: '100%',
                                maxWidth: '1320px', // Max width for responsiveness
                                height: '120px'
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

export default Transactions;
