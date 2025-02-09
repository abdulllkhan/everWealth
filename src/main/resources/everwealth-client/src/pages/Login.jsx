import React from 'react';
import { Input } from '@chakra-ui/react';
import { Button } from '@chakra-ui/react';
import { useNavigate } from 'react-router-dom'


function Login() {
    let navigate = useNavigate();
    return (
        <div>
            <Button colorScheme='teal' size='lg' onClick={() => navigate("/")}>
               Return To Main Menu
            </Button>
            <Input placeholder='Basic usage' />
        </div>
    )
}

export default Login;