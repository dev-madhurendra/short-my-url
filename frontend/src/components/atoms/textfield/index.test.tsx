import { render, fireEvent, screen } from "@testing-library/react";
import CustomTextField from "./index";

describe("CustomTextField", () => {
  it("should render with the correct initial value and call onChange handler", () => {
    const handleChange = jest.fn();
    const { getByPlaceholderText } = render(
      <CustomTextField
        placeholder="Enter text"
        value="Initial value"
        onChange={handleChange}
        isPassword={false}
      />
    );

    const input = getByPlaceholderText("Enter text") as HTMLInputElement;
    expect(input.value).toBe("Initial value");

    fireEvent.change(input, { target: { value: "Updated value" } });
    expect(handleChange).toHaveBeenCalledWith("Updated value");
  });

  it("should handles text change correctly", () => {
    let value = "";

    const handleChange = (newValue: string) => {
      value = newValue;
    };

    render(
      <CustomTextField
        placeholder="Enter your text"
        value={value}
        onChange={handleChange}
        isPassword={false}
        width="100%"
        height={40}
        size="medium"
        borderRadius="8px"
      />
    );

    const textField = screen.getByPlaceholderText("Enter your text");
    fireEvent.change(textField, { target: { value: "Hello" } });

    expect(value).toBe("Hello");
  });

  it(" should toggles password visibility correctly", () => {
    let value = "";

    const handleChange = (newValue: string) => {
      value = newValue;
    };

    render(
      <CustomTextField
        placeholder="Enter your password"
        value={value}
        onChange={handleChange}
        isPassword
        width="100%"
        height={40}
        size="medium"
        borderRadius="8px"
      />
    );

    const textField = screen.getByPlaceholderText("Enter your password");
    const toggleButton = screen.getByRole("button");

    fireEvent.change(textField, { target: { value: "Secret123" } });
    fireEvent.click(toggleButton);

    expect(textField.getAttribute("type")).toBe("text");

    fireEvent.click(toggleButton);

    expect(textField.getAttribute("type")).toBe("password");
  });
});
