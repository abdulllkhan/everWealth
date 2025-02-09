import React from 'react';
import '../../src/App.css';
import { useNavigate } from 'react-router-dom'
import { Button, Stack } from '@chakra-ui/react'



/*
    Might need help on functionality of the buttons..
    
*/


function Home() {
    let navigate = useNavigate();
    // const clickHandler = () => navigate("/login");
    return (
        <div>
            <div className="header">
                <div className="bar-left">
                    <h1>EverWealth</h1>
                </div>
                <div className="bar-right">
                    <div className="login-buttons">
                        <Stack spacing={4} direction='row' align='center'>
                            <Button colorScheme='teal' size='lg' onClick={() => navigate("/login")}>
                                Login
                            </Button>
                            <Button colorScheme='teal' size='lg' onClick={() => navigate("/signup")}>
                                Sign Up
                            </Button>
                        </Stack>
                    </div>
                </div>
            </div>
            <div className="body">
                <h1>Grow, learn, repeat.</h1>
            </div>
            <div className="footer">
                <h1>Grow, learn, repeat again.</h1>
            </div>
        </div>
    );
}
 
export default Home;