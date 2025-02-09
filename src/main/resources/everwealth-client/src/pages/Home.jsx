import React from "react";
import "../../src/App.css";
import { useNavigate } from "react-router-dom";
import { Button, Stack, VStack } from "@chakra-ui/react";

function Home() {
  let navigate = useNavigate();

  return (
    <div>
      <div className="header">
        <div className="bar-left"></div>
        <div className="bar-right">
          <div className="login-buttons">
            <Stack spacing={4} direction="row" align="center">
              {/* <Button variant="ghost" size="lg" onClick={() => navigate("/login")}>
                Log in
              </Button> */}
              <Button variant="ghost" size="lg" onClick={() => navigate("/myprofile")}>
                Log in
              </Button>
              <Button
                variant="outline"
                backgroundColor={"#7eb75d"}
                color="white"
                size="lg"
                onClick={() => navigate("/signup")}
              >
                Sign Up
              </Button>
            </Stack>
          </div>
        </div>
      </div>
      
      <div className="body">
        <VStack>
          <h1>EverWealth</h1>
          <h2>Grow, learn, repeat.</h2>
        </VStack>
      </div>

      {/* Add the Tree component here */}

      <div className="footer">
        <h1> Powered by Fantastic Four</h1>
      </div>
    </div>
  );
}

export default Home;
