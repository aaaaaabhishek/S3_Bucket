import React, { useState } from "react";
import {
  Container,
  Row,
  Col,
  Card,
  CardBody,
  Form,
  FormGroup,
  Label,
  Input,
  Button
} from "reactstrap";
const LoginPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Login attempted with:", { email, password });
  };

  return (
    <div style={{ 
      backgroundColor: "#0a1931", 
      minHeight: "100vh", 
      display: "flex", 
      justifyContent: "space-between", 
      alignItems: "center", 
      padding: "20px" 
    }}>
      {/* Logo on the Left Side */}
      <div style={{ marginLeft: "40px" ,marginTop:"100px"}}>
        <img 
          src="https://.com/images/modus-logo-white.png" 
          alt="Logo" 
          style={{ maxWidth: "450px" }} 
        />
      </div>
      
      <Container fluid>
        <Row className="justify-content-end">
          <Col xs={12} sm={8} md={6} lg={5} xl={4} className="d-flex justify-content-end">
            <Card 
              className="shadow-lg p-4 rounded border-0" 
              style={{ 
                background: "linear-gradient(135deg, #ffffff 10%, #e3f2fd 90%)", 
                width: "90%", 
                maxWidth: "350px", 
                borderRadius: "20px", 
                boxShadow: "0px 8px 20px rgba(0, 0, 0, 0.4)", 
                transition: "transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out",
                padding: "30px"
              }}
            >
              <CardBody>
                <h2 className="text-center mb-4" style={{ color: "#003580", fontWeight: "bold", fontSize: "28px", textTransform: "uppercase", letterSpacing: "2px" }}>Welcome Back</h2>
                <Form onSubmit={handleSubmit}>
                  <FormGroup>
                    <Label for="email" className="font-weight-bold" style={{ fontSize: "16px", color: "#333" }}>Email</Label>
                    <Input
                      type="email"
                      id="email"
                      value={email}
                      onChange={(e) => setEmail(e.target.value)}
                      required
                      className="p-2 rounded border-primary"
                      style={{ fontSize: "14px", backgroundColor: "#eef2f7", border: "2px solid #0056b3" }}
                    />
                  </FormGroup>
                  <FormGroup>
                    <Label for="password" className="font-weight-bold" style={{ fontSize: "16px", color: "#333" }}>Password</Label>
                    <Input
                      type="password"
                      id="password"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                      required
                      className="p-2 rounded border-primary"
                      style={{ fontSize: "14px", backgroundColor: "#eef2f7", border: "2px solid #0056b3" }}
                    />
                  </FormGroup>
                  <Button 
                    color="primary" 
                    block 
                    className="mt-3 py-2 font-weight-bold shadow-sm rounded"
                    style={{ fontSize: "18px", backgroundColor: "#0056b3", border: "none", letterSpacing: "1.5px", textTransform: "uppercase", transition: "background 0.3s ease-in-out, transform 0.2s ease-in-out" }}
                  >
                    Login
                  </Button>
                </Form>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default LoginPage;
