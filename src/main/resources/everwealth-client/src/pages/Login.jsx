import React from 'react';
import { useNavigate } from 'react-router-dom'

import { Button, Input, Stack } from "@chakra-ui/react"
import { useForm } from "react-hook-form"

import '../../src/App.css';

function Login() {
    let navigate = useNavigate();

    // below code doesn't even work... it messes everything up.

    // const {
    //     register,
    //     handleSubmit,
    //     formState: { errors },
    // } = useForm();

    // const onSubmit = handleSubmit((data) => {
    //     console.log(data);
    //     // navigate("/dashboard");
    //     // uncomment ^ this when we get it
    // });

    const onSubmit = (data) => {
        console.log("Login Data:", data);

        // Simulating authentication
        if (data.email === "test@example.com" && data.password === "password123") {
            alert("Login Successful!");
            navigate("/dashboard");
        } else {
            alert("Invalid email or password!");
        }
    };
    
    return (
        <div class="log-form">
        <h2>Login to your account</h2>
            <form>
                <input type="text" title="username" placeholder="Email" />
                <input type="password" title="password" placeholder="Password" />
                    <Stack spacing={2} direction='column' align='center'>
                    <Button colorScheme='teal' size='md' onClick={() => 
                        navigate("/dashboard")
                        /*
                        LOGIN CODE STUFF HERE!!!
                        */
                        }>
                    Login
                    </Button>
                    <Button colorScheme='teal' size='md' onClick={() => navigate("/signup")}>
                    Don't have an account?
                    </Button>
                </Stack>
            </form>
        </div>
    )
}

export default Login;