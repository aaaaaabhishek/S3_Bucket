import React, { useState } from "react";
import {
  Navbar,
  NavbarBrand,
  NavbarToggler,
  Collapse,
  Nav,
  NavItem,
  NavLink,
  Container,
  Button
} from "reactstrap";
import { Menu, X, ChevronDown, ChevronUp } from "lucide-react";

const OnePageLayout = () => {
  const [menuOpen, setMenuOpen] = useState(false);
  const [selectedRole, setSelectedRole] = useState("Welcome");
  const [showStudentOptions, setShowStudentOptions] = useState(false);
  const [showTeacherOptions, setShowTeacherOptions] = useState(false);


  return (
    <div
      className="vh-100 d-flex"
      style={{
        backgroundImage: "url('https://source.unsplash.com/1600x900/?sky,blue')",
        backgroundSize: "cover",
        backgroundPosition: "center",
      }}
    >
      {/* Sidebar */}
      <div className="d-flex flex-column p-4 bg-dark text-white shadow-lgd-flex flex-column align-items-center justify-content-center" style={{ width: "250px", minHeight: "100vh" }}>
        <h4 className="mb-4"></h4>
        
        {/* Student Button */}
        <Button
          color="primary"
          className="mb-3 d-flex justify-content-between align-items-center"
          onClick={() => setShowStudentOptions(!showStudentOptions)}
          style={{ fontSize: "1.25rem", width: "100%" }}

        >
          Student {showStudentOptions ? <ChevronUp size={18} /> : <ChevronDown size={18} />}
        </Button>

        {/* Sub-options for Student */}
        {showStudentOptions && (
          <div className="ps-3">
            <Button color="light" className="mb-2 w-100 text-start" onClick={() => setSelectedRole("Add Student")}>
              ➕ Add Student
            </Button>
            <Button color="danger" className="w-100 text-start" onClick={() => setSelectedRole("Delete Student")}>
              ❌ Delete Student
            </Button>
          </div>
        )}

         <Button
          color="primary"
          className="mb-3 d-flex justify-content-between align-items-center"
          onClick={() => setShowTeacherOptions(!showTeacherOptions)}
          style={{ fontSize: "1.25rem", width: "100%" }}

        >
          Teacher {showTeacherOptions ? <ChevronUp size={18} /> : <ChevronDown size={18} />}
        </Button>
        {showTeacherOptions && (
          <div className="ps-3">
            <Button color="light" className="mb-2 w-100 text-start" onClick={() => setSelectedRole("Add Teacher")}>
              ➕ Add Teacher
            </Button>
            <Button color="danger" className="w-100 text-start" onClick={() => setSelectedRole("Delete Teacher")}>
              ❌ Delete Teacher
            </Button>
          </div>
        )}
        
      </div>

      {/* Main Content */}
      <div className="flex-grow-1">
        {/* Navbar */}
        <Navbar expand="md" className="bg-dark bg-opacity-50 fixed-top shadow-sm">
  <Container className="d-flex justify-content-between">
    {/* Left-Side Logo */}
    <NavbarBrand href="#" className="d-flex align-items-center">
      <img
        src="https://moussystems.com/images/Modus-logo.png"
        alt="Logo"
        style={{ width: "100px", height: "30px" }}
      />
    </NavbarBrand>

    {/* Menu Toggler (Always on Right) */}
    <NavbarToggler onClick={() => setMenuOpen(!menuOpen)} className="ms-auto">
      {menuOpen ? <X size={30} className="text-white" /> : <Menu size={30} className="text-white" />}
    </NavbarToggler>

    <Collapse isOpen={menuOpen} navbar>
      <Nav className="ms-auto">
        <NavItem><NavLink href="#" className="text-white">Home</NavLink></NavItem>
        <NavItem><NavLink href="#" className="text-white">About</NavLink></NavItem>
        <NavItem><NavLink href="#" className="text-white">Services</NavLink></NavItem>
        <NavItem><NavLink href="#" className="text-white">Contact</NavLink></NavItem>
      </Nav>
    </Collapse>
  </Container>
</Navbar>        
      </div>
    </div>
  );
};

export default OnePageLayout;
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Project</title>
    <link rel="icon" href="https://ems.com/images/Modus-logo.png" /> <!-- Replace with your actual logo URL -->
</head>
<body>
    <div id="root"></div>
</body>
</html>
