import React from "react";
import TextField from "./index";
import { Meta, StoryObj } from "@storybook/react";

export default {
  title: "atoms/TextField",
  component: TextField,
} as Meta<typeof TextField>;

export const Default: StoryObj<typeof TextField> = {
  args: {
    placeholder: "Enter your text",
    value: "",
    onChange: (value: string) => console.log(value),
    width: "20%",
    height: 40,
    size: "medium",
    borderRadius: "8px",
  },
};

export const Password: StoryObj<typeof TextField> = {
  args: {
    placeholder: "Enter Password",
    value: "",
    onChange: (value: string) => console.log(value),
    isPassword: true,
    width: "20%",
    height: 40,
    size: "medium",
    borderRadius: "8px",
  },
};


